package org.example.service;

import org.example.dto.SellerDto;
import org.example.entity.Seller;
import org.example.repository.SellerRepository;

public class SellerService {
    private SellerRepository sellerRepository = SellerRepository.getInstance();
    private static SellerService sellerService;
    public static SellerService getInstance(){
        if(sellerService == null){

            sellerService = new SellerService();
        }
        return sellerService;
    }

    public Seller save(SellerDto sellerDto){
        Seller seller = new Seller();
        seller.setSellerName(sellerDto.sellerName());

        return sellerRepository.save(seller);
    }
}
