package cn.jiyang.bos.service.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cn.jiyang.bos.domain.base.Standard;

public interface StandardService {

	void save(Standard standard);

	Page<Standard> pageQuery(Pageable pageable);

}
