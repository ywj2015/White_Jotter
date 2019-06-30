<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span style="font-weight: bold;font-size: 20px;">最近更新</span>
                <!-- <el-button type="text" style="float: right;padding: 3px 0;"></el-button> -->
            </div>
            <div class="block">
                <el-timeline>
                    <el-timeline-item timestamp="2019/6/13" placement="top">
                        <el-card>
                            <h4>实现上传至服务器和输入URL两种方式添加封面</h4>
                            <p>ywj提交与 2019/6/13</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="2019/6/15" placement="top">
                        <el-card>
                            <h4>实现图书分类功能</h4>
                            <p>ywj提交与 2019/6/15</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="2019/6/16" placement="top">
                        <el-card>
                            <h4>实现图书分页，修复图书添加的BUG</h4>
                            <p>ywj提交与 2019/6/16</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="2019/6/17" placement="top">
                        <el-card>
                            <h4>实现搜索框模糊查询</h4>
                            <p>ywj提交与 2019/6/17</p>
                        </el-card>
                    </el-timeline-item>
                    <el-timeline-item timestamp="2019/6/18" placement="top">
                        <el-card>
                            <h4>实现图书修改功能</h4>
                            <p>ywj提交与 2019/6/18</p>
                        </el-card>
                    </el-timeline-item>
                </el-timeline>
            </div>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'UpdateCard'
}
</script>

<style scoped>
    .box-card {
        margin-top: 5px;
        width: 988px;
        height: 1000px;
        text-align: left;
    }
</style>
