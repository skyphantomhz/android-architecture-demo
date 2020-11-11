package com.example.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repo")
data class Repo(
    @PrimaryKey @ColumnInfo(name = "id") @SerializedName("id") var id: Int = 0,
    @SerializedName("node_id") var node_id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("full_name") var full_name: String? = null,
    @SerializedName("owner") var owner: Owner? = null,
    @SerializedName("private") var private: Boolean? = null,
    @SerializedName("html_url") var html_url: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("fork") var fork: Boolean? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("archive_url") var archive_url: String? = null,
    @SerializedName("assignees_url") var assignees_url: String? = null,
    @SerializedName("blobs_url") var blobs_url: String? = null,
    @SerializedName("branches_url") var branches_url: String? = null,
    @SerializedName("collaborators_url") var collaborators_url: String? = null,
    @SerializedName("comments_url") var comments_url: String? = null,
    @SerializedName("commits_url") var commits_url: String? = null,
    @SerializedName("compare_url") var compare_url: String? = null,
    @SerializedName("contents_url") var contents_url: String? = null,
    @SerializedName("contributors_url") var contributors_url: String? = null,
    @SerializedName("deployments_url") var deployments_url: String? = null,
    @SerializedName("downloads_url") var downloads_url: String? = null,
    @SerializedName("events_url") var events_url: String? = null,
    @SerializedName("forks_url") var forks_url: String? = null,
    @SerializedName("git_commits_url") var git_commits_url: String? = null,
    @SerializedName("git_refs_url") var git_refs_url: String? = null,
    @SerializedName("git_tags_url") var git_tags_url: String? = null,
    @SerializedName("git_url") var git_url: String? = null,
    @SerializedName("issue_comment_url") var issue_comment_url: String? = null,
    @SerializedName("issue_events_url") var issue_events_url: String? = null,
    @SerializedName("issues_url") var issues_url: String? = null,
    @SerializedName("keys_url") var keys_urls_url: String? = null,
    @SerializedName("labels_url") var labels_url: String? = null,
    @SerializedName("languages_url") var languages_url: String? = null,
    @SerializedName("merges_url") var merges_url: String? = null,
    @SerializedName("milestones_url") var milestones_url: String? = null,
    @SerializedName("notifications_url") var notifications_url: String? = null,
    @SerializedName("pulls_url") var pulls_url: String? = null,
    @SerializedName("releases_url") var releases_url: String? = null,
    @SerializedName("ssh_url") var ssh_url: String? = null,
    @SerializedName("stargazers_url") var stargazers_url: String? = null,
    @SerializedName("statuses_url") var statuses_url: String? = null,
    @SerializedName("subscribers_url") var subscribers_url: String? = null,
    @SerializedName("subscription_url") var subscription_url: String? = null,
    @SerializedName("tags_url") var tags_url: String? = null,
    @SerializedName("teams_url") var teams_url: String? = null,
    @SerializedName("trees_url") var trees_url: String? = null,
    @SerializedName("hooks_url") var hooks_url: String? = null
)/*{
	constructor(): this(null, null, null, null, null,null,
		null,null, null,null, null,null, null,
		null, null,null, null,null, null,
		null, null,null, null,null, null,null,
		null,null, null,null, null,null, null,null,
		null,null, null,null, null,null, null,null,
		null,null, null,null, null,null)
}*/