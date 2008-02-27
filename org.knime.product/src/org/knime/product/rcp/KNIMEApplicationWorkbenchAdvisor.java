/*
 * ----------------------------------------------------------------------------
 * This source code, its documentation and all appendant files
 * are protected by copyright law. All rights reserved.
 *
 * Copyright, 2003 - 2008
 * University of Konstanz, Germany.
 * Chair for Bioinformatics and Information Mining
 * Prof. Dr. Michael R. Berthold
 *
 * You may not modify, publish, transmit, transfer or sell, reproduce,
 * create derivative works from, distribute, perform, display, or in
 * any way exploit any of the content, in whole or in part, except as
 * otherwise expressly permitted in writing by the copyright owner or
 * as specified in the license file distributed with this product.
 *
 * If you have any questions please contact the copyright holder:
 * website: www.knime.org
 * email: contact@knime.org
 * ----------------------------------------------------------------------------
 */
package org.knime.product.rcp;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * Provides the initial workbench perspective ID (KNIME perspective).
 * 
 * @author Florian Georg, University of Konstanz
 */
public class KNIMEApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
    /**
     * {@inheritDoc}
     */
    @Override
    public String getInitialWindowPerspectiveId() {
        return "org.knime.workbench.ui.ModellerPerspective";
    }

    /**
     * Initializes the application. At the moment it just forces the product to
     * save and restore the window and perspective settings (remembers whether
     * editors are open, etc.).
     * 
     * @see org.eclipse.ui.application.WorkbenchAdvisor
     *  #initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
     */
    @Override
    public void initialize(final IWorkbenchConfigurer configurer) {
        super.initialize(configurer);

        configurer.setSaveAndRestore(true);
    }

    /**
     * Create our window advisor that configures the workbench.
     * 
     * @see org.eclipse.ui.application.WorkbenchAdvisor
     *      #createWorkbenchWindowAdvisor
     *      (org.eclipse.ui.application.IWorkbenchWindowConfigurer)
     */
    @Override
    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(
            final IWorkbenchWindowConfigurer configurer) {

        return new KNIMEApplicationWorkbenchWindowAdvisor(configurer);
    }
}
