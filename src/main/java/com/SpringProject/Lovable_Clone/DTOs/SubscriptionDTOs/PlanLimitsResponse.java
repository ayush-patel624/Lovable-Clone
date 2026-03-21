package com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {
}
