package com.manageruser.sharedmodel.editingdocument.document;

import com.manageruser.sharedmodel.core.document.BaseDocument;
import com.manageruser.sharedmodel.editingdocument.DocumentStatus;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public abstract class EditableDocument<D extends BaseDocument> extends BaseDocument {
    @Nullable
    protected D editingDocument;
    @Nullable
    protected DocumentStatus documentStatus;
}
