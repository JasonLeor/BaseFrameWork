package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS 资源接口
 */
@RestController
@RequestMapping("/cms/resource")
public class CMSResourceController {
//    @Autowired
//    private FacilityService facilityService;
//    @Autowired
//    private CityService cityService;
//    @Autowired
//    private SpaceTransform spaceTransform;
//
//    /**
//     * 获取设施列表
//     */
////    @PostMapping("getFacilities")
////    public List<Facility> getFacilities(@RequestBody FacilityFilter facilityFilter) {
////        Page<PFacility> page = facilityService.getAllFacilities(facilityFilter);
////        return page.getContent().stream().map(pFacility -> spaceTransform.toFacility(pFacility)).collect(Collectors.toList());
////    }
//
//    /**
//     * 创建设施
//     */
//    @PostMapping("createFacility")
//    public void createFacility(@RequestBody @Valid FacilityCreator creator) {
//        facilityService.newFacility(creator);
//    }
//
//    /**
//     * 修改设施
//     */
//    @PostMapping("updateFacility")
//    public void updateFacility(@RequestBody @Valid FacilityUpdater updater) {
//        PFacility facility = facilityService.getFacility(updater.getFacilityId());
//        if (facility == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "无效设施");
//        }
//        facilityService.updateFacility(updater);
//    }
//
//    /**
//     * 操作设施
//     */
//    @PostMapping("operateFacility")
//    public void operateFacility() {
//    }
//
//    /**
//     * 新建城市资源
//     */
//    @PostMapping("createCity")
//    public void createCity(@RequestBody @Valid CityCreator cityCreator) {
//        City city = cityService.getCity(cityCreator.getCityId());
//        if (city != null) {
//            throw new ServiceException(ExceptionCode.SERVICE, "该城市已存在");
//        }
//        cityService.newCity(cityCreator);
//    }
//
//    /**
//     * 更新城市 信息
//     */
//    @PostMapping("updateCity")
//    public void updateCity(@RequestBody @Valid CityUpdater cityUpdater) {
//        cityService.updateCity(cityUpdater);
//    }
}
