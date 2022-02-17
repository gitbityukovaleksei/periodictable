package ua.com.lineup.periodictable.service;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import java.io.Serializable;
import java.util.List;

public class ElementCriteria implements Serializable, Criteria {
    private String name;

    private Integer atomicNumber;

    private String alternativeName;

    private String symbol;

    private String appearance;

    private String discovery;

    private String discoveryYear;

    private Integer groupBlock;

    private Integer period;
    @Override
    public String getAlias() {
        return null;
    }

    @Override
    public Criteria setProjection(Projection projection) {
        return null;
    }

    @Override
    public Criteria add(Criterion criterion) {
        return null;
    }

    @Override
    public Criteria addOrder(Order order) {
        return null;
    }

    @Override
    public Criteria setFetchMode(String s, FetchMode fetchMode) throws HibernateException {
        return null;
    }

    @Override
    public Criteria setLockMode(LockMode lockMode) {
        return null;
    }

    @Override
    public Criteria setLockMode(String s, LockMode lockMode) {
        return null;
    }

    @Override
    public Criteria createAlias(String s, String s1) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createAlias(String s, String s1, JoinType joinType) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createAlias(String s, String s1, int i) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createAlias(String s, String s1, JoinType joinType, Criterion criterion) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createAlias(String s, String s1, int i, Criterion criterion) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, JoinType joinType) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, int i) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, String s1) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, String s1, JoinType joinType) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, String s1, int i) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, String s1, JoinType joinType, Criterion criterion) throws HibernateException {
        return null;
    }

    @Override
    public Criteria createCriteria(String s, String s1, int i, Criterion criterion) throws HibernateException {
        return null;
    }

    @Override
    public Criteria setResultTransformer(ResultTransformer resultTransformer) {
        return null;
    }

    @Override
    public Criteria setMaxResults(int i) {
        return null;
    }

    @Override
    public Criteria setFirstResult(int i) {
        return null;
    }

    @Override
    public boolean isReadOnlyInitialized() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public Criteria setReadOnly(boolean b) {
        return null;
    }

    @Override
    public Criteria setFetchSize(int i) {
        return null;
    }

    @Override
    public Criteria setTimeout(int i) {
        return null;
    }

    @Override
    public Criteria setCacheable(boolean b) {
        return null;
    }

    @Override
    public Criteria setCacheRegion(String s) {
        return null;
    }

    @Override
    public Criteria setComment(String s) {
        return null;
    }

    @Override
    public Criteria addQueryHint(String s) {
        return null;
    }

    @Override
    public Criteria setFlushMode(FlushMode flushMode) {
        return null;
    }

    @Override
    public Criteria setCacheMode(CacheMode cacheMode) {
        return null;
    }

    @Override
    public List list() throws HibernateException {
        return null;
    }

    @Override
    public ScrollableResults scroll() throws HibernateException {
        return null;
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) throws HibernateException {
        return null;
    }

    @Override
    public Object uniqueResult() throws HibernateException {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(Integer atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public void setAlternativeName(String alternativeName) {
        this.alternativeName = alternativeName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getDiscovery() {
        return discovery;
    }

    public void setDiscovery(String discovery) {
        this.discovery = discovery;
    }

    public String getDiscoveryYear() {
        return discoveryYear;
    }

    public void setDiscoveryYear(String discoveryYear) {
        this.discoveryYear = discoveryYear;
    }

    public Integer getGroupBlock() {
        return groupBlock;
    }

    public void setGroupBlock(Integer groupBlock) {
        this.groupBlock = groupBlock;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}
