package com.senac.pi.model.dao;

import java.util.List;

public interface DaoInterface {

    public abstract void createXml(List<?> data);

    public abstract List<?> readXml();

    public abstract void updateXml(List<?> data);

    public abstract void deleteXml(int id);
}
