       identification division.
       program-id. CobolTasklet1.
       environment division.
         input-output section.
         file-control.
           select f assign to 'file1.txt'
           organization is sequential.
       data division.
       file section.
       fd f.
       01 rec-num pic 9(5).
       working-storage section.
       procedure division.
       open output f.
       move 100 to rec-num.
       write rec-num.
       move 200 to rec-num.
       write rec-num.
       close f.
