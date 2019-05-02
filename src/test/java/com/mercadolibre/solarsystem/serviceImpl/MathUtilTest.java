package com.mercadolibre.solarsystem.serviceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.mercadolibre.solarsystem.utils.MathUtil;


@RunWith(SpringRunner.class)
public class MathUtilTest {
	
	@Test
	public void testAligntDots() {
		Assert.assertTrue(MathUtil.areDotsAlligned(0D, 1D, 2D, 3D, 4D, 5D));
	}
}
