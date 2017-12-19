package com.livenaked.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CMS 订单接口
 */
@RestController
@RequestMapping("/cms/order")
public class CMSOrderController {
//    @Autowired
//    private SpaceOrderService spaceOrderService;
//    @Autowired
//    private CourseOrderService courseOrderService;
//    @Autowired
//    private CourseOrderTransform courseOrderTransform;
//    @Autowired
//    private SpaceOrderTransform spaceOrderTransform;
//
//    /**
//     * 课程订单列表
//     */
//    @PostMapping("course/getOrders")
//    public Pagination<CourseOrderItem> getCourseOrderList(@RequestBody CourseOrderFilter filter) {
//        Page<PCourseOrder> orders = courseOrderService.getOrders(filter);
//        Pagination page = new Pagination(orders.getTotalPages(), (int) orders.getTotalElements(), orders.getNumber(), orders.getSize());
//        page.setResult(orders.getContent().stream().map(courseOrder -> courseOrderTransform.toOrderItem(courseOrder)).collect(Collectors.toList()));
//        return page;
//    }
//
//    /**
//     * 获取 课程订单详情
//     */
//    @PostMapping("course/getOrderDetail")
//    public void getCourseOrderDetail(@RequestBody String orderId) {
//
//    }
//
//    /**
//     * 操作课程订单
//     */
//    @PostMapping("course/operateOrder")
//    public void operateCourseOrder(@RequestBody CourseOrderOperator operator) {
//
//    }
//
////----------------------------------------------------------------------------------------------------------------
//
//    /**
//     * 空间订单列表
//     */
//    @PostMapping("space/getOrders")
//    public Pagination<SpaceOrderItem> getSpaceOrderList(@RequestBody SpaceOrderFilter filter) {
//
//        return null;
//    }
//
//    /**
//     * 获取 空间订单详情
//     */
//    @PostMapping("space/getOrderDetail")
//    public void getSpaceOrderDetail(@RequestBody String orderId) {
//
//    }
//
//    /**
//     * 操作空间订单
//     */
//    @PostMapping("space/operateOrder")
//    public void operateSpaceOrder(@RequestBody SpaceOrderOperator operator) {
//
//    }

}
