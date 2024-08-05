package com.manageruser.sharedmodel.editingdocument.dto;

import com.manageruser.sharedmodel.core.dto.BaseDTO;
import com.manageruser.sharedmodel.editingdocument.DocumentStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@NoArgsConstructor
public abstract class EditableDocumentDTO<D extends BaseDTO> extends BaseDTO {

    protected D editingDocument;
    protected DocumentStatus documentStatus;
}
