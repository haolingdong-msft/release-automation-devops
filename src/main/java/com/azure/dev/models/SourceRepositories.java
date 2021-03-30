// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.dev.models;

import com.azure.dev.fluent.models.SourceRepositoriesInner;
import java.util.List;

/** An immutable client-side representation of SourceRepositories. */
public interface SourceRepositories {
    /**
     * Gets the continuationToken property: A token used to continue this paged request; 'null' if the request is
     * complete.
     *
     * @return the continuationToken value.
     */
    String continuationToken();

    /**
     * Gets the pageLength property: The number of repositories requested for each page.
     *
     * @return the pageLength value.
     */
    Integer pageLength();

    /**
     * Gets the repositories property: A list of repositories.
     *
     * @return the repositories value.
     */
    List<SourceRepository> repositories();

    /**
     * Gets the totalPageCount property: The total number of pages, or '-1' if unknown.
     *
     * @return the totalPageCount value.
     */
    Integer totalPageCount();

    /**
     * Gets the inner com.azure.dev.fluent.models.SourceRepositoriesInner object.
     *
     * @return the inner object.
     */
    SourceRepositoriesInner innerModel();
}
