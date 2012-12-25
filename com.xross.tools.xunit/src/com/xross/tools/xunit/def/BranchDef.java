package com.xross.tools.xunit.def;

import java.util.ArrayList;
import java.util.List;

import com.xross.tools.xunit.Branch;
import com.xross.tools.xunit.Locator;
import com.xross.tools.xunit.Unit;
import com.xross.tools.xunit.impl.BranchImpl;

public class BranchDef extends UnitDef{
	private UnitDef locatorDef;
	private List<UnitDef> branchUnitDefs = new ArrayList<UnitDef>();
	
	public UnitDef getLocatorDef() {
		return locatorDef;
	}
	
	public void setLocatorDef(UnitDef locatorDef) {
		this.locatorDef = locatorDef;
	}
	
	public List<UnitDef> getBranchUnitDefs() {
		return branchUnitDefs;
	}
	
	public void addBranchUnitDef(UnitDef branchUnitDef) {
		branchUnitDefs.add(branchUnitDef);
	}

	protected Unit createDefault(){
		return new BranchImpl();
	}

	protected Unit createInstance() throws Exception{
		Branch branch = (Branch)super.createInstance();
		branch.setLocator((Locator)getInstance(locatorDef));
		
		for(UnitDef def : branchUnitDefs){
			Unit unit = getInstance(def);
			branch.add(def.getKey(), unit);
		}
		
		return branch;
	}		
}
