package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS banner 接口
 */
@RestController
@RequestMapping("/cms/banner")
public class CMSBannerController {
//    @Autowired
//    private BannerService bannerService;
//
//    /**
//     * 获取banner 列表
//     */
//    @PostMapping("/getBanners")
//    public List<ResponseBanner> getBanners(@RequestBody String key) {
//        List<PBanner> banners = bannerService.getBanners();
//        return banners.stream().map(ResponseBanner::new).collect(Collectors.toList());
//    }
//
//    /**
//     * 获取banner详情
//     */
//    @PostMapping("/getBanner")
//    public ResponseBanner getBanner(@RequestBody Long bannerId) {
//        PBanner banner = bannerService.getBanner(bannerId);
//        return new ResponseBanner(banner);
//    }
//
//    /**
//     * 创建banner
//     */
//    @PostMapping("/createBanner")
//    public Long createBanners(@RequestBody BannerCreater bannerCreater) {
//        PBanner banner = bannerService.create(bannerCreater);
//        return banner.getId();
//    }
//
//    /**
//     * 更新banner
//     */
//    @PostMapping("/updateBanner")
//    public void updateBanners(@RequestBody BannerUpdater bannerUpdater) {
//        bannerService.update(bannerUpdater);
//    }
//
//    /**
//     * 删除banner
//     */
//    @PostMapping("/deleteBanner")
//    public void deleteBanners(@RequestBody List<Long> bannerIds) {
//        bannerService.delete(bannerIds);
//    }
}
