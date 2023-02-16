package com.example.batch.job01;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import jp.osscons.opensourcecobol.libcobj.call.CobolRunnable;
import jp.osscons.opensourcecobol.libcobj.common.CobolCallParams;
import jp.osscons.opensourcecobol.libcobj.common.CobolControl;
import jp.osscons.opensourcecobol.libcobj.common.CobolFrame;
import jp.osscons.opensourcecobol.libcobj.common.CobolModule;
import jp.osscons.opensourcecobol.libcobj.common.CobolUtil;
import jp.osscons.opensourcecobol.libcobj.data.AbstractCobolField;
import jp.osscons.opensourcecobol.libcobj.data.CobolDataStorage;
import jp.osscons.opensourcecobol.libcobj.data.CobolDecimal;
import jp.osscons.opensourcecobol.libcobj.data.CobolFieldAttribute;
import jp.osscons.opensourcecobol.libcobj.data.CobolFieldFactory;
import jp.osscons.opensourcecobol.libcobj.exceptions.CobolGoBackException;
import jp.osscons.opensourcecobol.libcobj.exceptions.CobolRuntimeException;
import jp.osscons.opensourcecobol.libcobj.exceptions.CobolStopRunException;
import jp.osscons.opensourcecobol.libcobj.file.CobolFile;
import jp.osscons.opensourcecobol.libcobj.file.CobolFileFactory;
import jp.osscons.opensourcecobol.libcobj.ui.CobolResultSet;

@Component
public class CobolTasklet1 implements CobolRunnable, Tasklet {

  private boolean initialized = false;
  private CobolModule cobolCurrentModule;
  private int frameIndex;
  private CobolModule module;
  private CobolFrame frame;
  private static boolean cobolInitialized = false;
  private CobolCallParams cobolSaveCallParams = null;
  private CobolCallParams cobolCallParams = null;
  private boolean cobolErrorOnExitFlag;
  private int entry;

  private CobolRunnable cob_unifunc;

  private static final Logger logger = LoggerFactory.getLogger(CobolTasklet1.class);

  @Override
  public RepeatStatus execute(StepContribution conribution, ChunkContext chunkContext) throws Exception {
    logger.info("called CobolTasklet1.");
    this.run();
    return RepeatStatus.FINISHED;
  }

  @Override
  public int run(CobolDataStorage... argStorages) {
    return CobolTasklet1_(0, argStorages);
  }

  @Override
  public void cancel() {
    CobolTasklet1_(-1);
  }

  @Override
  public boolean isActive() {
    return false;
  }

  public CobolResultSet execute() {
    int returnCode = run_module(0);
    return new CobolResultSet(returnCode);
  }

  public int CobolTasklet1_(int entry, CobolDataStorage... argStorages) {
    this.entry = entry;
    return this.run_module(entry);
  }

  int run_module(int entry) {
    this.module = new CobolModule(null, null, null, null, 0, '.', '$', ',', 1, 1, 1, 0, null);

    /* Start of function code */

    /* CANCEL callback handling */
    if (entry < 0) {
      if (!this.initialized) {
        CobolDecimal.cobInitNumeric();
        return 0;
      }
      h_F.close(0, null);
      this.initialized = false;
      return 0;
    }

    /* Push module stack */
    CobolModule.push(module);

    /* Initialize program */
    if (!this.initialized) {
      b_RETURN_CODE.set((int) 0);

      h_F = CobolFileFactory.makeCobolFileInstance(
          /* select_name = */ "f",
          /* file_status = */ h_F_status,
          /* assign = */ c_1,
          /* record = */ f_f_record,
          /* record_size = */ null,
          /* record_min = */ 5,
          /* record_max = */ 5,
          /* nkeys = */ 0,
          /* keys = */ null,
          /* organization = */ (char) 0,
          /* access_mode = */ (char) 1,
          /* lock_mode = */ (char) 0,
          /* open_mode = */ (char) 0,
          /* flag_optional = */ false,
          /* last_open_mode = */ (char) 0,
          /* special = */ (char) 0,
          /* flag_nonexistent = */ false,
          /* flag_end_of_file = */ false,
          /* flag_begin_of_file = */ false,
          /* flag_first_read = */ (char) 0,
          /* flag_read_done = */ false,
          /* flag_select_features = */ (char) 0,
          /* flag_needs_nl = */ false,
          /* flag_needs_top = */ false,
          /* file_version = */ (char) 0);

      this.initialized = true;
    }
    /* PROCEDURE DIVISION */
    try {
      CobolStopRunException.dummy();
      CobolGoBackException.dummy();
      /* Entry dispatch */
      execEntry(1);

    } catch (CobolGoBackException e) {
      return e.getReturnCode();
    } catch (CobolStopRunException e) {
      CobolStopRunException.stopRun();
      System.exit(e.getReturnCode());
    }
    /* Pop module stack */
    CobolModule.pop();

    /* Program return */
    return b_RETURN_CODE.intValue();
  }

  public CobolControl[] contList = {
      new CobolControl(0, CobolControl.LabelType.label) {
        public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

          return Optional.of(contList[1]);
        }
      },
      /* Entry CobolTasklet1 */
      new CobolControl(1, CobolControl.LabelType.label) {
        public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

          return Optional.of(contList[2]);
        }
      },
      /* MAIN SECTION */
      new CobolControl(2, CobolControl.LabelType.section) {
        public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

          return Optional.of(contList[3]);
        }
      },
      /* MAIN PARAGRAPH */
      new CobolControl(3, CobolControl.LabelType.label) {
        public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {
          /* CobolTasklet1.cbl:14: OPEN */
          {
            CobolRuntimeException.code = 0;
            {
              h_F.open(2, 1, null);
            }
            if (CobolRuntimeException.code != 0) {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, 4).run();
            }
          }
          /* CobolTasklet1.cbl:15: MOVE */
          {
            b_f_record.setBytes("00100", 5);
          }
          /* CobolTasklet1.cbl:16: WRITE */
          CobolRuntimeException.code = 0;
          {
            h_F.write(f_rec_num, 0, null);
          }
          if (CobolRuntimeException.code != 0) {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, 4).run();
          }
          /* CobolTasklet1.cbl:17: MOVE */
          {
            b_f_record.setBytes("00200", 5);
          }
          /* CobolTasklet1.cbl:18: WRITE */
          CobolRuntimeException.code = 0;
          {
            h_F.write(f_rec_num, 0, null);
          }
          if (CobolRuntimeException.code != 0) {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, 4).run();
          }
          /* CobolTasklet1.cbl:19: CLOSE */
          {
            CobolRuntimeException.code = 0;
            {
              h_F.close(0, null);
            }
            if (CobolRuntimeException.code != 0) {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, 4).run();
            }
          }

          return Optional.of(CobolControl.pure());
        }
      },
      /* Default Error Handler */
      new CobolControl(4, CobolControl.LabelType.label) {
        public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

          if ((CobolFile.errorFile.flag_select_features & CobolFile.COB_SELECT_FILE_STATUS) == 0) {
            CobolFile.defaultErrorHandle();
            CobolStopRunException.stopRunAndThrow(1);
          }

          return Optional.of(CobolControl.pure());
        }
      },
      CobolControl.pure()
  };

  public void execEntry(int start) throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {
    Optional<CobolControl> nextLabel = Optional.of(contList[start]);
    while (nextLabel.isPresent()) {
      CobolControl section = nextLabel.get();
      nextLabel = section.run();
    }
  }

  public static void main(String[] args) {
    CobolUtil.cob_init(args, cobolInitialized);
    CobolDecimal.cobInitNumeric();
    new CobolTasklet1().CobolTasklet1_(0);
    CobolStopRunException.stopRun();
  }

  public CobolTasklet1() {
    init();
  }

  public void init() {
    try {
      /* Data storage */

      cob_unifunc = null;

      /* PROGRAM-ID : CobolTasklet1 */
      b_RETURN_CODE = new CobolDataStorage(4); /* RETURN-CODE */
      b_f_record = new CobolDataStorage(5); /* f_record */

      /* End of data storage */

      initAttr();

      /* Fields */

      /* PROGRAM-ID : CobolTasklet1 */
      f_rec_num = CobolFieldFactory.makeCobolField(5, b_f_record, a_2); /* rec-num */
      f_f_record = CobolFieldFactory.makeCobolField(5, b_f_record, a_1); /* f_record */

      /* End of fields */

      /* Constants */

      c_1 = CobolFieldFactory.makeCobolField(9, "file1.txt", a_1);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void initAttr() {
    /* Attributes */

    a_1 = new CobolFieldAttribute(33, 0, 0, 0, null);
    a_2 = new CobolFieldAttribute(16, 5, 0, 0, null);

  }

  /* Data storage */

  /* PROGRAM-ID : CobolTasklet1 */
  private CobolDataStorage b_RETURN_CODE; /* RETURN-CODE */
  private CobolDataStorage b_f_record; /* f_record */

  /* End of data storage */

  /* Fields */

  /* PROGRAM-ID : CobolTasklet1 */
  private AbstractCobolField f_rec_num; /* rec-num */
  private AbstractCobolField f_f_record; /* f_record */

  /* End of fields */

  private static AbstractCobolField f_native;

  /* Constants */

  private AbstractCobolField c_1;

  /* Attributes */

  private CobolFieldAttribute a_2;
  private CobolFieldAttribute a_1;

  /* File f */
  private CobolFile h_F = null;
  private byte[] h_F_status = new byte[4];

  private void cobolPushCallStackList(String programId) {
  }

  private void cobolFatalError(int errorCode) {
  }

  private void cobolCheckVersion(String sourceFile, int packageVersion, int patchVersion) {
  }

  private void cobolSetCancel(String programId, Object a, Object b) {
  }

  private void cobolPopCallStackList() {
  }

  private static CobolDataStorage makeCobolDataStorage(byte... bytes) {
    return new CobolDataStorage(bytes);
  }
}
