package com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs;

public record PlanLimitsResponse(
        String planName,
        int maxTokensPerDay,
        int maxProjects,
        boolean unlimitedAi
) {
}
