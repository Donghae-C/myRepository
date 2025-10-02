package ex0808.exam05;

public class Course {
	/**
	 * 모든 사람을 허용(등록)
	 */
	public void register01(Applicant<?> applicant) {
		System.out.println(applicant.getClass().getSimpleName() + "가 신청했습니다. - register01");
	}
	
	/**
	 * 직장인만 허용(등록)
	 */
	public void register02(Applicant<? super Worker> applicant) {
		System.out.println(applicant.getClass().getSimpleName() + "가 신청했습니다. - register01");
	}
	
	/**
	 * 학생만 허용(등록)
	 */
	public void register03(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getClass().getSimpleName() + "가 신청했습니다. - register01");
	}
}
