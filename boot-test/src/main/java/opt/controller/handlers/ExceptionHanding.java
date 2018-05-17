package opt.controller.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.spring.web.advice.ProblemHandling;

/**
 * Created by Administrator on 2017/12/26.
 */
@ControllerAdvice
public class ExceptionHanding implements ProblemHandling {

    @Override
    public ResponseEntity<Problem> handleProblem(ThrowableProblem problem, NativeWebRequest request) {


        System.out.println("aaaaaaaaaaaaaa");


        return null;
    }

    @Override
    public ResponseEntity<Problem> process(ResponseEntity<Problem> entity) {

        System.out.println("bbbbbbbbb");


        return null;
    }
}
