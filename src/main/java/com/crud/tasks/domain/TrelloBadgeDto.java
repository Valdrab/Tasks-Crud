package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloBadgeDto {
    private int votes;
    private TrelloAttachmentsByTypeDto trelloAttachmentsByTypeDto;
}
