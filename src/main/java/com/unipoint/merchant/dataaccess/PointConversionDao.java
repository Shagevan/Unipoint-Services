package com.unipoint.merchant.dataaccess;

import java.util.List;

import com.unipoint.merchant.model.Merchant;
import com.unipoint.merchant.model.PointConversion;

public interface PointConversionDao {
	public void addPointConvrsion(PointConversion pointConversion);
	public List<PointConversion> getAllPointConvrsions();
	public void deletePointConvrsion(Merchant merchant);
	public PointConversion getPointConvrsion(Merchant merchant);
}
