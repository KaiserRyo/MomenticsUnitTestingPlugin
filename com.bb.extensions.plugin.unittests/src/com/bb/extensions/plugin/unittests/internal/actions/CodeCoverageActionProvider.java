/*******************************************************************************
 * Copyright (C) 2013 Research In Motion Limited
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package com.bb.extensions.plugin.unittests.internal.actions;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.actions.OpenFileAction;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

/**
 * @author tallen
 * 
 */
public class CodeCoverageActionProvider extends CommonActionProvider {
	/**
	 * The open action
	 */
	private BaseSelectionListenerAction _openAction;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator
	 * .ICommonActionExtensionSite)
	 */
	@Override
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		OpenFileAction commonOpen = new OpenFileAction(
				((ICommonViewerWorkbenchSite) aSite.getViewSite()).getPage());
		_openAction = new CodeCoverageOpenAction(commonOpen);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionGroup#fillContextMenu(org.eclipse.jface.
	 * action.IMenuManager)
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN, _openAction);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionGroup#fillActionBars(org.eclipse.ui.IActionBars
	 * )
	 */
	@Override
	public void fillActionBars(IActionBars actionBars) {
		super.fillActionBars(actionBars);

		actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
				_openAction);

		actionBars.updateActionBars();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.actions.ActionGroup#setContext(org.eclipse.ui.actions.
	 * ActionContext)
	 */
	@Override
	public void setContext(ActionContext context) {
		super.setContext(context);

		if ((context != null)
				&& (context.getSelection() instanceof IStructuredSelection)) {
			IStructuredSelection selection = (IStructuredSelection) context
					.getSelection();

			_openAction.selectionChanged(selection);
		}
	}
}
