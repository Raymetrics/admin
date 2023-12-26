package com.raymetrics.admin.web.service;

import com.raymetrics.admin.web.entity.News;
import com.raymetrics.admin.web.model.NewsResDTO;
import com.raymetrics.admin.web.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;


    @Transactional(readOnly = true)
    public Page<NewsResDTO> getList(Map<String,Object> param) {

        int page = Optional.ofNullable(param.get("page"))
                .map(Object::toString)
                .map(Integer::valueOf)
                .orElse(0);
        int size = 10;
        PageRequest pageable = PageRequest.of(page, size);
        Page<News> newsPage = newsRepository.findAllByOrderByNewsNoDesc(pageable);

        return newsPage.map(NewsResDTO::of);

    }


    public NewsResDTO getOne(int id) {
        Optional<News> news = newsRepository.findById(id);
        if (news.isPresent()) {
            return NewsResDTO.of(news.get());
        } else {
            return null;
        }
    }

    @Transactional
    public News regist(HashMap<String, Object> paramMap) {
        News inquiry = newsRepository.save(new News(paramMap));
        return inquiry;
    }
}
