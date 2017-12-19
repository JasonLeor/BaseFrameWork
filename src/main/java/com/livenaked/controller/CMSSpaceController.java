package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS space 接口
 */
@RestController()
@RequestMapping("/cms/space")
public class CMSSpaceController {
//
//    @Autowired
//    private SpaceService spaceService;
//
//    @Autowired
//    private AccountService accountService;
//
//    @Autowired
//    private LocationService locationService;
//
//    @Autowired
//    private SpaceTransform spaceTransform;
//
//    /**
//     * 获取 space 列表
//     */
//    @PostMapping("/getSpaces")
//    public List<SpaceItem> getSpaces(@RequestBody SpaceFilter spaceFilter) {
//
//        Page<PSpace> pSpaces = spaceService.getSpaces(spaceFilter);
//
//        return pSpaces.getContent().stream().map(pSpace -> spaceTransform.toSpaceItem(pSpace)).collect(Collectors.toList());
//    }
//
//    /**
//     * 获取空间详情
//     */
//    @PostMapping("/getSpaceDetail")
//    public SpaceDetail getSpace(@RequestBody Long spaceId) {
//        PSpace pSpace = spaceService.getValidSpace(spaceId);
//        if (pSpace == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "未发现空间信息");
//        }
//        return spaceTransform.toSpaceDetail(pSpace);
//    }
//
//    /**
//     * 创建空间
//     */
//    @PostMapping("/createSpace")
//    public void createSpace(@Valid @RequestBody SpaceCrater spaceCrater) {
//        spaceService.createSpace(spaceCrater);
//    }
//
//    /**
//     * 修改空间信息
//     */
//    @PostMapping("/updateSpace")
//    public void updateSpace(@Valid @RequestBody SpaceUpdater spaceUpdater) {
//        PSpace space = spaceService.getSpace(spaceUpdater.getId());
//        if (space == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "未发现空间信息");
//        }
//        spaceService.updateSpace(space, spaceUpdater);
//    }
//
//    /**
//     * 空间开门
//     */
//    @PostMapping("/openGate")
//    public void openGate(@RequestBody Long spaceId) {
//    }
//
//    /**
//     * 通过locationId获取合作伙伴的空间列表
//     */
//    @PostMapping("/getPartnerHubRoomList")
//    public List<HubRoom> getPartnerHubRoomList(@RequestBody Long locationId) {
//        PLocation location = locationService.getLocation(locationId);
//        if (location == null) {
//            throw new ServiceException(ExceptionCode.NOT_FOUND, "无效的location");
//        }
//        return spaceService.getHubRoomList(PartnerTypeEnum.valueOf(location.getLocationType()), location.getResourceId());
//    }
//

}
