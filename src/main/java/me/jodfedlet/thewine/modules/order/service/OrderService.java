package me.jodfedlet.thewine.modules.order.service;

import me.jodfedlet.thewine.modules.order.dto.in.SaleProductToCustomerInDto;

import java.util.Set;

public interface OrderService {

    String saleProductToCustomer(Set<SaleProductToCustomerInDto> saleProductInDto);

    String buyProductFromSupplier(Set<SaleProductToCustomerInDto> saleProductInDto);


}
