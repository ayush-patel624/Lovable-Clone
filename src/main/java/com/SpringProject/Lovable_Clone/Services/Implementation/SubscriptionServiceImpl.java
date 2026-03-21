package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.CheckoutRequest;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.CheckoutResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.PortalResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.SubscriptionResponse;
import com.SpringProject.Lovable_Clone.Services.SubscriptionService;
import org.springframework.stereotype.Service;


@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
