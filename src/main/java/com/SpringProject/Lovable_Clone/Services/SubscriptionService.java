package com.SpringProject.Lovable_Clone.Services;


import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.CheckoutRequest;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.CheckoutResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.PortalResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription(Long userId);

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(Long userId);
}
