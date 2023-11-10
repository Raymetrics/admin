package com.raymetrics.admin.web.repository;

import com.raymetrics.admin.web.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
//public interface InquiryRepository extends GenericRepository<Inquiry>
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    List<Inquiry> findAllByOrderByInquiryNoDesc();
    Inquiry findFirstByInquiryNo(int inquiryNo);
    Inquiry findFirstByInquiryNoAndPw(int inquiryNo, String pw);
    void delete(Inquiry inquiry);
}
