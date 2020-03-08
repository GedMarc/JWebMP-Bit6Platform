package com.jwebmp.plugins.sixbitplatform.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleExclusions;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class Bit6ExclusionsModule
		implements IGuiceScanModuleExclusions<Bit6ExclusionsModule>
{
	@Override
	public @NotNull Set<String> excludeModules()
	{
		Set<String> strings = new HashSet<>();
		strings.add("com.jwebmp.plugins.bit6");
		return strings;
	}
}
