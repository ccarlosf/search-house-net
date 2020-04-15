/**
 * Created by 瓦力.
 */
var regionCountMap = {}, // 地区数据
    labels = [], // 标签列表
    params = {
        orderBy: 'lastUpdateTime',
        orderDirection: 'desc'
    },
    customLayer; // 麻点图

function load(city, regions, aggData) {
    // 百度地图API功能
    var map = new BMap.Map("allmap", {minZoom: 12}); // 创建实例。设置地图显示12最大级别为城市
    // var point = new BMap.Point(city.baiduMapLongitude, city.baiduMapLatitude); // 城市中心
    var point = new BMap.Point(116.404185, 39.915574);
    map.centerAndZoom(point, 12); // 初始化地图，设置中心点坐标及地图级别

    map.addControl(new BMap.NavigationControl({enableGeolocation: true})); // 添加比例尺控件
    map.addControl(new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT})); // 左上角
    map.enableScrollWheelZoom(true); // 开启鼠标滚轮缩放

    for (var i = 0; i < aggData.length; i++) {
        regionCountMap[aggData[i].key] = aggData[i].count;
    }

    drawRegion(map, regions);

  /*  loadHouseData();

    // 缩放事件
    map.addEventListener('zoomend', function (event) {
        mapResize(event.target);
    });
    // 地图拖拽完成事件
    map.addEventListener('dragend', function (event) {
        mapResize(event.target);
    });*/
}

/**
 * 刻画地区
 * @param map
 * @param regionList
 */
function drawRegion(map, regionList) {
    var boundary = new BMap.Boundary();
    var polygonContext = {};
    var regionPoint;
    var textLabel;
    for (var i = 0; i < regionList.length; i++) {

        regionPoint = new BMap.Point(regionList[i].baiduMapLongitude, regionList[i].baiduMapLatitude);

        var houseCount = 0;
        if (regionList[i].en_name in regionCountMap) {
            houseCount = regionCountMap[regionList[i].en_name];
        }

        var textContent = '<p style="margin-top: 20px; pointer-events: none">' +
            regionList[i].cn_name + '</p>' + '<p style="pointer-events: none">' +
            houseCount + '套</p>';
        textLabel = new BMap.Label(textContent, {
            position: regionPoint, // 标签位置
            offset: new BMap.Size(-40, 20) // 文本偏移量
        });

        textLabel.setStyle({
            height: '78px',
            width: '78px',
            color: '#fff',
            backgroundColor: '#0054a5',
            border: '0px solid rgb(255, 0, 0)',
            borderRadius: "50%",
            fontWeight: 'bold',
            display: 'inline',
            lineHeight: 'normal',
            textAlign: 'center',
            opacity: '0.8',
            zIndex: 2,
            overflow: 'hidden'
        });

        map.addOverlay(textLabel); // 将标签画在地图上
        labels.push(textLabel);

        // 记录行政区域覆盖物
        polygonContext[textContent] = []; // 点集合
        (function (textContent) { // 闭包传参
            boundary.get(city.cn_name + regionList[i].cn_name, function(rs) { // 获取行政区域
                var count = rs.boundaries.length; // 行政区域边界点集合长度
                if (count === 0) {
                    alert('未能获取当前输入行政区域')
                    return;
                }

                for (var j = 0; j < count; j++) {
                    // 建立多边形覆盖物
                    var polygon = new BMap.Polygon(
                        rs.boundaries[j],
                        {
                            strokeWeight: 2,
                            strokeColor:'#0054a5',
                            fillOpacity: 0.3,
                            fillColor: '#0054a5'
                        }
                    );
                    map.addOverlay(polygon); // 添加覆盖物
                    polygonContext[textContent].push(polygon);
                    polygon.hide(); // 初始化隐藏边界
                }
            })
        })(textContent);

        textLabel.addEventListener('mouseover', function (event) {
            var label = event.target;
            var boundaries = polygonContext[label.getContent()];

            label.setStyle({backgroundColor: '#1AA591'});
            for (var n = 0; n < boundaries.length; n++) {
                boundaries[n].show();
            }
        });

        textLabel.addEventListener('mouseout', function (event) {
            var label = event.target;
            var boundaries = polygonContext[label.getContent()];

            label.setStyle({backgroundColor: '#0054a5'});
            for (var n = 0; n < boundaries.length; n++) {
                boundaries[n].hide();
            }
        });

        textLabel.addEventListener('click', function (event) {
            var label = event.target;
            var map = label.getMap();
            map.zoomIn();
            map.panTo(event.point);
        });
    }




}
