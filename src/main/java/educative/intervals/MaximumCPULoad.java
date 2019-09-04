package educative.intervals;
import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {

  public static int findMaxCPULoad(List<Job> jobs) {
    int cpuLoad = 0;
    int currentCpuLoad =0;
    Collections.sort(jobs,(job1,job2) -> Integer.compare(job1.start,job2.start));

    PriorityQueue<Job> jobQueue = new PriorityQueue<>((job1,job2) -> Integer.compare(job1.end,job2.end));
    for (Job job :jobs) {
      while (!jobQueue.isEmpty() && job.start > jobQueue.peek().end) {
        Job removedJob = jobQueue.poll();
        currentCpuLoad -= removedJob.cpuLoad;

      }
      jobQueue.offer(job);
      currentCpuLoad += job.cpuLoad;
      cpuLoad = Math.max(cpuLoad,currentCpuLoad);

    }
    return cpuLoad;
  }


  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}

