package com.write.Quill;

import name.vbraun.view.write.Graphics;
import name.vbraun.view.write.Page;

public class CommandCreateGraphics extends Command {

	protected final Graphics graphics;
	
	public CommandCreateGraphics(Page page, Graphics toAdd) {
		super(page);
		graphics = toAdd;
	}

	@Override
	public void execute() {
		UndoManager.getApplication().add(getPage(), graphics);
	}

	@Override
	public void revert() {
		UndoManager.getApplication().remove(getPage(), graphics);
	}

	@Override
	public String toString() {
		int n = Book.getBook().getPageNumber(getPage());
		return "Add pen stroke on page "+n;
	}
}
