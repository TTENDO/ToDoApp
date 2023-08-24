package com.ttendo.todoapp

data class ActivityModel(
    val image:Int = 1,
    val activityName:String = "",
    val activityTime:String = "",
    val activityDescription:String ="",
    val activityStatus:ActivityStatus = ActivityStatus.Pending
)
enum class ActivityStatus{
    Completed,Pending,Failed,Postponed
}