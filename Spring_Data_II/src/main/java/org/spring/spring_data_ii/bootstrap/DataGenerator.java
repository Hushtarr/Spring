package org.spring.spring_data_ii.bootstrap;

import org.spring.spring_data_ii.entity.*;
import org.spring.spring_data_ii.enums.Status;
import org.spring.spring_data_ii.repository.CartRepository;
import org.spring.spring_data_ii.repository.ItemRepository;
import org.spring.spring_data_ii.repository.MerchantRepository;
import org.spring.spring_data_ii.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component

public class DataGenerator implements CommandLineRunner
    {
    private final PaymentRepository paymentRepository;
    private final MerchantRepository merchantRepository;
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public DataGenerator(PaymentRepository paymentRepository, MerchantRepository merchantRepository, CartRepository cartRepository, ItemRepository itemRepository)
        {
        this.paymentRepository = paymentRepository;
        this.merchantRepository = merchantRepository;
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
        }

    @Override
    public void run(String... args) throws Exception
        {

        Merchant merchant1 = new Merchant("Merchant A", "A001", new BigDecimal("2.50"), new BigDecimal("0.05"), 7);
        Merchant merchant2 = new Merchant("Merchant B", "B002", new BigDecimal("1.75"), new BigDecimal("0.04"), 5);
        Merchant merchant3 = new Merchant("Merchant C", "C003", new BigDecimal("3.00"), new BigDecimal("0.06"), 10);
        Merchant merchant4 = new Merchant("Merchant D", "D004", new BigDecimal("2.25"), new BigDecimal("0.05"), 3);
        Merchant merchant5 = new Merchant("Merchant E", "E005", new BigDecimal("2.00"), new BigDecimal("0.04"), 14);


        merchantRepository.save(merchant1);
        merchantRepository.save(merchant2);
        merchantRepository.save(merchant3);
        merchantRepository.save(merchant4);
        merchantRepository.save(merchant5);

        Payment payment1 = new Payment(LocalDate.of(2023, 5, 15), new BigDecimal("100.00"), Status.SUCCESS);
        Payment payment2 = new Payment(LocalDate.of(2023, 5, 16), new BigDecimal("200.00"), Status.FAILURE);
        Payment payment3 = new Payment(LocalDate.of(2023, 5, 17), new BigDecimal("150.00"), Status.SUCCESS);
        Payment payment4 = new Payment(LocalDate.of(2023, 5, 18), new BigDecimal("300.00"), Status.FAILURE);
        Payment payment5 = new Payment(LocalDate.of(2023, 5, 19), new BigDecimal("250.00"), Status.SUCCESS);

        payment1.setMerchant(merchant1);
        payment2.setMerchant(merchant2);
        payment3.setMerchant(merchant3);
        payment4.setMerchant(merchant4);
        payment5.setMerchant(merchant5);

        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("90.00"), new BigDecimal("10.00"), LocalDate.of(2023, 5, 20));
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("180.00"), new BigDecimal("20.00"), LocalDate.of(2023, 5, 21));
        PaymentDetail paymentDetail3 = new PaymentDetail(new BigDecimal("135.00"), new BigDecimal("15.00"), LocalDate.of(2023, 5, 22));
        PaymentDetail paymentDetail4 = new PaymentDetail(new BigDecimal("270.00"), new BigDecimal("30.00"), LocalDate.of(2023, 5, 23));
        PaymentDetail paymentDetail5 = new PaymentDetail(new BigDecimal("225.00"), new BigDecimal("25.00"), LocalDate.of(2023, 5, 24));

        payment1.setPaymentDetail(paymentDetail1);
        payment2.setPaymentDetail(paymentDetail2);
        payment3.setPaymentDetail(paymentDetail3);
        payment4.setPaymentDetail(paymentDetail4);
        payment5.setPaymentDetail(paymentDetail5);

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);
        paymentRepository.save(payment3);
        paymentRepository.save(payment4);
        paymentRepository.save(payment5);

        System.out.println(paymentRepository.findById(2L).get().getPaymentDetail().getCommissionAmount());
        // paymentRepository.delete(payment1);

        Item item1 = new Item("Item A", "A001");
        Item item2 = new Item("Item B", "B002");
        Item item3 = new Item("Item C", "C003");
        Item item4 = new Item("Item D", "D004");
        Item item5 = new Item("Item E", "E005");
        Item item6 = new Item("Item F", "F006");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        cart1.setItems(Arrays.asList(item1,item2,item3));
        cart2.setItems(Arrays.asList(item4,item5,item6));

        itemRepository.saveAll(Arrays.asList(item1,item2,item3,item4,item5,item6));
        cartRepository.saveAll(Arrays.asList(cart1,cart2));
        }
    }
