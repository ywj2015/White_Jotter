<template>
    <div>
        <el-card class="box-card">
            <div style="font-size: 45px;color: azure;white-space: nowrap">Talking is nothing, show you my code.</div>
            <a href="https://github.com/ywj2015" target="_blank">
                <img src="../../assets/icons/icon6.png" class="git-link" alt="">
            </a>
            <a href="https://blog.csdn.net" target="_blank">
                <img src="../../assets/icons/csdn.png" class="csdn-link" alt="">
            </a>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'Slogan'
}
</script>

<style scoped>
    .box-card {
        width: 100%;
        height: 150px;
        background-color: #222;
        text-align: center;
        margin-top: 5px;
    }

    .git-link {
        width: 80px;
    }

    .csdn-link {
        width: 60px;
        margin-bottom: 8px;
        margin-left: 10px;
    }
</style>
