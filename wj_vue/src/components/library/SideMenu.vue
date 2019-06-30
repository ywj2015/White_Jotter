<template>
    <div>
        <el-menu
            default-active="0"
            class="categories"
            @select="handSelect"
            active-text-color="red">
            <el-menu-item index="0">
                <i class="el-icon-menu"></i>
                <span slot="title">全部</span>
            </el-menu-item>
            <el-menu-item index="1">
                <i class="el-icon-menu"></i>
                <span slot="title">文学</span>
            </el-menu-item>
            <el-menu-item index="2">
                <i class="el-icon-menu"></i>
                <span slot="title">流行</span>
            </el-menu-item>
            <el-menu-item index="3">
                <i class="el-icon-menu"></i>
                <span slot="title">文化</span>
            </el-menu-item>
            <el-menu-item index="4">
                <i class="el-icon-menu"></i>
                <span slot="title">生活</span>
            </el-menu-item>
            <el-menu-item index="5">
                <i class="el-icon-menu"></i>
                <span slot="title">经济</span>
            </el-menu-item>
            <el-menu-item index="6">
                <i class="el-icon-menu"></i>
                <span slot="title">科技</span>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default {
    name: 'SideMenu',
    data() {
        return {
            cid: ''
        }
    },
    methods: {
        handSelect(key, keyPath) {
            console.log(key, keyPath)
            this.cid = key
            this.$emit('indexSelect')
        }
    }
}
</script>

<style scoped>
    .categories {
        /* position: fixed; */
        /* left: -600px;
        top: 100px; */
        margin: 20px 0 40px 50px;
        width: 150px; 
    }
</style>
