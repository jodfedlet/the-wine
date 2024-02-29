package me.jodfedlet.thewine.modules.order.service;

import lombok.RequiredArgsConstructor;
import me.jodfedlet.thewine.modules.order.dto.in.SaleProductToCustomerInDto;
import me.jodfedlet.thewine.modules.order.entity.Order;
import me.jodfedlet.thewine.modules.order.entity.OrderItem;
import me.jodfedlet.thewine.modules.order.repository.OrderItemRepository;
import me.jodfedlet.thewine.modules.order.repository.OrderRepository;
import me.jodfedlet.thewine.modules.product.dto.out.ProductOutDto;
import me.jodfedlet.thewine.modules.product.entity.Product;
import me.jodfedlet.thewine.modules.product.repository.ProductRepository;
import me.jodfedlet.thewine.modules.product.service.ProductService;
import me.jodfedlet.thewine.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public String saleProductToCustomer(Set<SaleProductToCustomerInDto> saleProductInDto) {

        Order order = new Order();

        List<OrderItem> orderItems = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        for(SaleProductToCustomerInDto saleProduct : saleProductInDto) {
           Product product =  checkIfProductIsAvailableInStock(saleProduct.productId(), saleProduct.quantity());

            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(product)
                    .quantity(saleProduct.quantity())
                    .build();

            product.decreaseStock(saleProduct.quantity());
            orderItems.add(orderItem);
            products.add(product);
        }

        productRepository.saveAll(products);
        orderItemRepository.saveAll(orderItems);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public String buyProductFromSupplier(Set<SaleProductToCustomerInDto> saleProductInDto) {
        return null;
    }

    private Product checkIfProductIsAvailableInStock(String productId, int quantity) {
        Product product =  productRepository.findById(productId).orElseThrow(() -> new BadRequestException("Product not found"));
        product.checkIfAvailableInStock(quantity);
        return product;
    }
}
