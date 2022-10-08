package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.baseModel.Element;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "drinks")
@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Drink extends Element {
}
