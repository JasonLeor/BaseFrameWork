package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS Location接口
 */
@RestController
@RequestMapping("/cms/location")
public class CMSLocationController {
//    @Autowired
//    private LocationService locationService;
//    @Autowired
//    private LocationTransform locationTransform;
//
//    /**
//     * 位置列表
//     */
//    @RequestMapping("getLocations")
//    public List<LocationItem> getLocations(@RequestBody LocationFilter filter) {
//        Page<PLocation> locations = locationService.getLocations(filter);
//        return locations.getContent().stream().map(location -> locationTransform.toLocationItem(location)).collect(Collectors.toList());
//    }
//
//    /**
//     * 位置详细信息
//     */
//    @RequestMapping("getLocationDetail")
//    public LocationDetail getLocationDetail(@RequestBody Long locationId) {
//        PLocation location = locationService.getLocation(locationId);
//        if (location == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "无位置信息");
//        }
//        return locationTransform.toLocationDetail(location);
//    }
//
//    /**
//     * 创建 新位置
//     */
//    @RequestMapping("createLocation")
//    public void createLocation(@Valid @RequestBody LocationCreator creator) {
//        locationService.newLocation(creator);
//    }
//
//    /**
//     * 更新位置信息
//     */
//    @RequestMapping("updateLocation")
//    public void updateLocation(@Valid @RequestBody LocationUpdater updater) {
//        PLocation location = locationService.getLocation(updater.getLocationId());
//        if (location == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "无位置信息");
//        }
//        locationService.updateLocation(updater);
//    }
//
//    /**
//     * 操作位置
//     */
//    @RequestMapping("operateLocation")
//    public void operateLocation() {
//
//    }
//
//    /**
//     * 获取合作伙伴 location 资源
//     *
//     * @param locationType 类型
//     */
//    @PostMapping("/getPartnerHubList")
//    public List<Hub> getPartnerHubList(@RequestBody PartnerTypeEnum locationType) {
//        return locationService.getPartnerHubList(locationType);
//    }
}
