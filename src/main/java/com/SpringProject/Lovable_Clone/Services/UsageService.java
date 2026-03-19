package com.SpringProject.Lovable_Clone.Services;


import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.PlanLimitsResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.UsageTodayResponse;

public interface UsageService {
     UsageTodayResponse getTodayUsageOfUser(Long userId);

     PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
