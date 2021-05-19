package com.hungpk.threekingdomtactic.service;

import com.hungpk.threekingdomtactic.config.exception.SystemException;
import com.hungpk.threekingdomtactic.model.Group;
import com.hungpk.threekingdomtactic.payload.request.GroupRequest;
import com.hungpk.threekingdomtactic.repository.GroupRepository;
import com.hungpk.threekingdomtactic.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;

    private final ModelMapper modelMapper;

    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id).orElseThrow(() -> new SystemException(MessageUtils.NOT_FOUND));
    }

    public void create(GroupRequest body) {
        var entity = modelMapper.map(body, Group.class);
        groupRepository.save(entity);
    }

    public void update(Long id, GroupRequest body) {
        var entity = groupRepository.findById(id).get();
        entity.setName(body.getName());
        groupRepository.save(entity);
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
