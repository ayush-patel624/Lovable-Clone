package com.SpringProject.Lovable_Clone.Services.Implementation;

import com.SpringProject.Lovable_Clone.DTOs.AuthDTO.UserProfileResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.PlanLimitsResponse;
import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.UsageTodayResponse;
import com.SpringProject.Lovable_Clone.Services.UsageService;
import com.SpringProject.Lovable_Clone.Services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl  implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
