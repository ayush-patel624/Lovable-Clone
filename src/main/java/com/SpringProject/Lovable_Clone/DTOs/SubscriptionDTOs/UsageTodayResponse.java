package com.SpringProject.Lovable_Clone.DTOs.SubscriptionDTOs;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokensLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
