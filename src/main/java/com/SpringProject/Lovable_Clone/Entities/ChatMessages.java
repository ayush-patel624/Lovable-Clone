package com.SpringProject.Lovable_Clone.Entities;


import com.SpringProject.Lovable_Clone.Enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessages {

    long id;

    ChatSession chatSession;

    MessageRole role;

    String content;
    String toolCalls;

    Integer tokensUsed;

    Instant createdAt;


}
