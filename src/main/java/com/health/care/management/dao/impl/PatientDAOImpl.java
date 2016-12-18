package com.health.care.management.dao.impl;

import static com.health.care.management.constant.Constant.FETCH_PATIENT_DETAILS_BY_USERNAME;
import static com.health.care.management.constant.Constant.SAVE_PATIENT;
import static com.health.care.management.constant.Constant.UPDATE_PATIENT_INFO;
import static com.health.care.management.util.Util.getSqlDateFromJavaDate;

import com.health.care.management.HealthCareServiceConfiguration;
import com.health.care.management.constant.Constant;
import com.health.care.management.dao.PatientDAO;
import com.health.care.management.domain.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PatientDAOImpl implements PatientDAO {

    private JdbcTemplate jdbcTemplate;

    public PatientDAOImpl() {
        super();
        this.jdbcTemplate = HealthCareServiceConfiguration.getJdbcConnection();
    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.PatientDAO#findPatientById(int)
     */
    @Override
    public Patient findPatientById(int userId) {
        return jdbcTemplate.queryForObject(FETCH_PATIENT_DETAILS_BY_USERNAME, new Object[] { userId }, new PatientRowMapper());

    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.PatientDAO#savePatientInfo(com.health.care.management.domain.Patient)
     */
    @Override
    public int savePatientInfo(Patient patient) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            //
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst = con.prepareStatement(SAVE_PATIENT, new String[] { "patient_id" });
                pst.setString(1, patient.getFirstName());
                pst.setString(2, patient.getLastName());
                pst.setInt(3, patient.getSex());
                pst.setDate(4, getSqlDateFromJavaDate(patient.getDob()));
                pst.setString(5, patient.getAddress());
                pst.setLong(6, patient.getPhoneNumber());
                pst.setString(7, patient.getAlergies());
                pst.setInt(8, patient.getUserId());
                return pst;
            }
        }, keyHolder);
        return Math.toIntExact(keyHolder.getKey().longValue());
    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.PatientDAO#updatePatientInfo(com.health.care.management.domain.Patient)
     */
    @Override
    public int updatePatientInfo(Patient patient) {
        return jdbcTemplate.update(UPDATE_PATIENT_INFO, new Object[] { patient.getFirstName(), patient.getLastName(), patient.getSex(), patient.getDob(), patient.getAddress(),
                patient.getPhoneNumber(), patient.getAlergies(), patient.getUserId() });
    }

    /* (non-Javadoc)
     * @see com.health.care.management.dao.PatientDAO#fetchPastAppointmentDetials(int)
     */
    @Override
    public List<Map<String, Object>> fetchPastAppointmentDetials(int patientId) {
        return jdbcTemplate.queryForList(Constant.FETCH_PAST_APPOINTMENTS, new Object[] { patientId });
    }
    

	/* (non-Javadoc)
	 * @see com.health.care.management.dao.PatientDAO#updatePatientStatus(int, java.lang.String)
	 */
	@Override
	public int updatePatientStatus(int patientId, String status) {
		return jdbcTemplate.update(Constant.UPDATE_STATUS_OF_PATIENT_BY_ID,new Object[]{status,patientId});
	}

	/* (non-Javadoc)
	 * @see com.health.care.management.dao.PatientDAO#checkStatusOfPatient(int)
	 */
	@Override
	public String checkStatusOfPatient(int patientId) {
		return jdbcTemplate.queryForObject(Constant.CHECK_PATIENT_STATUS, new Object[]{patientId}, String.class);
	}

    /**
     * Row mapper for patient table
     *
     */
    private class PatientRowMapper implements RowMapper<Patient> {

        @Override
        public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
            Patient patient = new Patient();
            patient.setId(rs.getLong("patient_id"));
            patient.setFirstName(rs.getString("first_name"));
            patient.setLastName(rs.getString("last_name"));
            patient.setSex(rs.getInt("sex"));
            patient.setDob(rs.getDate("date_of_birth"));
            patient.setPhoneNumber(rs.getLong("mobile_number"));
            patient.setAddress(rs.getString("address"));
            patient.setAlergies(rs.getString("alergies"));
            patient.setUserId(rs.getInt("user_id"));
            return patient;
        }

    }


}
