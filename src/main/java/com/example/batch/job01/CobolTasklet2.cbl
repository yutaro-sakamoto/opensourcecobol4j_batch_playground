       identification division.
       program-id. CobolTasklet2.
       environment division.
         input-output section.
         file-control.
           select f assign to 'file1.txt'
           organization is sequential.
           select g assign to 'file2.txt'
           organization is sequential.
       data division.
       file section.
       fd f.
       01 f-rec pic 9(5).
       fd g.
       01 g-rec pic 9(5).
       working-storage section.
       procedure division.

       open input f.
       open output g.

       read f.
       move f-rec to g-rec.
       add 1 to g-rec.
       write g-rec.

       read f.
       move f-rec to g-rec.
       add 1 to g-rec.
       write g-rec.

       close f.
       close g.
