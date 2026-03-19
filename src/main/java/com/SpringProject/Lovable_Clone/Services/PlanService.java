package com.SpringProject.Lovable_Clone.Services;


import com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs.PlanResponse;

import java.util.List;

public interface PlanService {
     List<PlanResponse> getAllActivePlans();
}
