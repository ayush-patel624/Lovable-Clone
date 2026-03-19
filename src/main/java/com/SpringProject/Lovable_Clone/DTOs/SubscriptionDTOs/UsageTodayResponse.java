package com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs;

public record UsageTodayResponse(
        int tokensUsed,
        int tokensLimit,
        int previewsRunning,
        int previewsLimit
) {
}
