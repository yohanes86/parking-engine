package com.emobile.smis.web.mapper;

import java.util.List;

import com.emobile.smis.web.data.PersonInChargeVO;
import com.emobile.smis.web.entity.PersonInCharge;

public interface PersonInChargeMapper {

	public void createPersonInCharge(PersonInChargeVO personInCharge);

	public void updatePersonInCharge(PersonInChargeVO personInCharge);
	
	public PersonInCharge findPersonInChargeById(PersonInCharge personInCharge);
	public PersonInCharge findLastPersonInCharge();
//			@Param("productId") int productId, @Param("id") int id);
	
	public PersonInChargeVO findPersonInChargeByIdForVo(PersonInCharge personInCharge);
	
	public List<PersonInChargeVO> findPersonInChargeByDealerShowroomId(PersonInCharge personInCharge);
//			@Param("productId") int productId, @Param("dealerShowroomId") int dealerShowroomId);
	
	public List<PersonInCharge> findListPersonInChargeByParam(PersonInCharge personInCharge);
	
	public PersonInCharge findPicByNameDealerIdAndPosition(PersonInChargeVO personInCharge);
}
