/*******************************************************************************
 * Copyright (C) 2013 Research In Motion Limited
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 
package com.bb.extensions.plugin.unittests.internal.navigator;

import org.eclipse.core.resources.IFolder;

/**
 * @author tallen
 * 
 */
public interface IWrapsFolder {
	/**
	 * @return The folder this element wraps
	 */
	public IFolder getFolder();
}
