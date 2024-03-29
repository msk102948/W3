package com.sparta.w3.service;

import com.sparta.w3.model.FanMemo;
import com.sparta.w3.model.FanMemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FanMemoService {

    private final FanMemoRepository fanMemoRepository;

    public List<FanMemo> memoList() {
        return fanMemoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public FanMemo fanmemoView(Long id) {
        return fanMemoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 게시글 입니다.")
        );
    }
}
